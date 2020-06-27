package com.exuberant.tutorials.javaconcept.interviews.shutterfly;

public class VintagePhone {
    String dialled = "";
    String lastDialled = "";
    Receiver receiver;


    public void dial(char character) {
        if (character == 'R') {
            validateNumberAndCall(lastDialled);
        }
        dialled += character;
        validateNumberAndCall(dialled);
    }

    private void validateNumberAndCall(String number) {
        if (isValidNumber(number)) {
            call(number);
        }
    }

    private boolean isValidNumber(String number) {
        if (number.length() > 3) {
            return true;
        }
        return false;
    }

    private void call(String number) {
        lastDialled = number;
        System.err.println("Calling number " + number);
    }

    public void reset() {
        dialled = "";
        disconectCall();
    }

    private void disconectCall() {
        System.err.println("Disconnecting Call....");
    }
}