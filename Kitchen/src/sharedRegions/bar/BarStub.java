package sharedRegions.bar;

import commonStructures.ClientCom;
import commonStructures.Message;
import sharedRegions.interfaces.Bar;
import sharedRegions.interfaces.SharedRegionStub;

/**
 * Stub do Bar.
 */
public class BarStub extends SharedRegionStub implements Bar {
    /**
     * Instanciação do Stub do bar.
     *
     * @param hostName nome da máquina em que o servidor se encontra alojado.
     * @param port     porta em que servidor se encontra à escuta.
     */
    public BarStub(String hostName, int port) {
        super(hostName, port);
    }

    @Override
    public char lookAround() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.LOOK_AROUND);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.LOOK_AROUND_RESPONSE);
        con.close();
        return inMessage.getTask();
    }

    @Override
    public void returnToBar() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.RETURN_TO_BAR);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public int enter() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.BAR_ENTER);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.BAR_ENTER_RESPONSE);
        con.close();
        return inMessage.getArrivalOrder();
    }

    @Override
    public void callWaiter() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.CALL_WAITER);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();

    }

    @Override
    public void alertWaiter() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.BAR_ALERT_WAITER);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }
    
    @Override
    public void prepareBill() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.PREPARE_BILL);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public void shouldArriveEarlier() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.BAR_SHOULD_ARRIVE_EARLIER);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public void sayGoodBye() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.SAY_GOODBYE);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public void exit(long id) {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.BAR_EXIT).setStudentId(id);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public void waiterFinished() {
        ClientCom clientCom = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.WAITER_FINISHED);
        clientCom.writeObject(outMessage);
        inMessage = waitForMessage(clientCom, Message.Type.LOGGER_MESSAGE_RECEIVED);
        clientCom.close();
    }


}
