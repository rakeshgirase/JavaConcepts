package com.exuberant.tutorials.javaconcept.interviews.codesignal;

/*Check if the removing one number brings the series in sequence
 * For example [1,3,2,3] is almost in sequence after removing 3 at index 1
 * */
public class AlmostInSequenceChecker {

    public boolean isAlmostInSequence(int[] sequence) {
        int firstOddIndex = -1;
        boolean firstOddFound = false;
        boolean isAlmostInSequence = true;
        int length = sequence.length;
        if(length==2){
            isAlmostInSequence = sequence[1]-sequence[0]==1;
        } else {
            for (int index = 0; index < length; index++) {
                //out of three elements two are odd then break
                if (isValidIndex(index + 2, length) && sequence[index + 2] - sequence[index] != 1 && sequence[index + 2] - sequence[index + 1] != 1) {
                    isAlmostInSequence = false;
                    break;
                }
            }
        }


        return isAlmostInSequence;
    }

    public boolean isAlmostInSequenceOneFail(int[] sequence) {
        int firstOddIndex = -1;
        boolean firstOddFound = false;
        boolean isAlmostInSequence = true;
        int length = sequence.length;
        for (int index = 0; index < length; index++) {
            //out of three elements two are odd then break
            if (isValidIndex(index + 2, length) && sequence[index + 1] - sequence[index] != 1 && sequence[index + 2] - sequence[index + 1] != 1 && sequence[index + 2] - sequence[index] != 1) {
                isAlmostInSequence = false;
                break;
            } else if (isValidIndex(index + 2, length) && sequence[index + 1] - sequence[index] != 1 && sequence[index + 2] - sequence[index + 1] != 1 && sequence[index + 2] - sequence[index] != 1) {
                isAlmostInSequence = false;
                break;
            }

        }
        return isAlmostInSequence;
    }
    /*public boolean isAlmostInSequence(int[] sequences) {
        int outOfOrder = 0;
        *//*If two numbers are not in sequence then return false*//*
        int length = sequences.length;
        for (int i = 1; i < length; i++) {
            if (sequences[i] - sequences[i - 1] != 1) {
                outOfOrder++;
                if (isValidIndex(i + 2, length) && (sequences[i+2] - sequences[i] != 1 && sequences[i+2] - sequences[i+1] != 1)) {
                    outOfOrder++;
                    if(outOfOrder >= 2)
                        break;
                }
            }
        }
        return outOfOrder < 2;
    }*/

    private boolean isValidIndex(int index, int length) {
        System.err.println("Checking " + index + " and length " + length + ": " + (index < length));
        return index < length;
    }
}
