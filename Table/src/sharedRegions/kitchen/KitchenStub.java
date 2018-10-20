package sharedRegions.kitchen;

import commonStructures.ClientCom;
import commonStructures.Message;
import sharedRegions.interfaces.Kitchen;
import sharedRegions.interfaces.SharedRegionStub;

/**
 * Stub da Kitchen
 */
public class KitchenStub extends SharedRegionStub implements Kitchen {
    /**
     * Instaciação da Kitchen
     *
     * @param hostName nome da máquina em que o servidor se encontra alojado.
     * @param port     server's listening  port number
     */
    public KitchenStub(String hostName, int port) {
        super(hostName, port);
    }

    @Override
    public void watchNews() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.WATCH_NEWS);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();

    }

    @Override
    public void handNoteToChef() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.HAND_NOTE_TO_CHEF);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();

    }

    @Override
    public void startPreparation() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.START_PREPARATION);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public void proceedToPresentation() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.PROCEED_TO_PRESENTATION);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();

    }

    @Override
    public void alertWaiter() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.KITCHEN_ALERT_WAITER);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public void collectPortion() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.COLLECT_PORTION);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public boolean allPortionsDelivered() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.ALL_PORTIONS_DELIVERED);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.ALL_PORTIONS_DELIVERED_RESPONSE);
        con.close();
        return inMessage.getKitchenAllPortionsDelivered();
    }

    @Override
    public void allStudentsServed() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.KITCHEN_ALL_STUDENTS_SERVED);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public void haveNextPortionReady() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.HAVE_NEXT_PORTION_READY);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public void continuePreparation() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.CONTINUE_PREPARATION);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }

    @Override
    public boolean orderCompleted() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.ORDER_COMPLETED);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.ORDER_COMPLETED_RESPONSE);
        con.close();
        return inMessage.getKitchenOrderCompleted();
    }

    @Override
    public void cleanUp() {
        ClientCom con = createAndOpenConnection();
        Message   inMessage, outMessage;
        outMessage = new Message(Message.Type.CLEAN_UP);
        con.writeObject(outMessage);
        inMessage = waitForMessage(con, Message.Type.MESSAGE_RECEIVED);
        con.close();
    }
}
