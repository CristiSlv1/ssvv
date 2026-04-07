package lab3.inclass;

public class Set {

    int[] vS;
    int nVS;

    Set(int capacity) {
        vS = new int[capacity];
        nVS = 0;
    }

    boolean AddAValue(int newVal) {
        if (nVS >= vS.length) {
            return false;
        }
        if (IsInTheSet(newVal)) {
            return false;
        }
        vS[nVS++] = newVal;
        return true;
    }

    public boolean IsInTheSet(int checkVal) {
        int i = 0;
        while ((i < nVS) && (vS[i] != checkVal)) {
            i++;
        }
        return i < nVS;
    }
}

