package Lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitOperationsTest { // Bits Count starts from 0

    public BitOperations bits = new BitOperations();

    @Test
    void getBitTest1(){  // get bit number 5 in 5161 -> returns 1
        assertEquals(1,bits.getBit(5161,5));
    }

    @Test
    void getBitTest2(){  // get bit number 6 in 436 -> returns 0
        assertEquals(0,bits.getBit(436,6));
    }

    @Test
    void setBitTest1(){ // set bit number 8 in 663 -> returns 919
        assertEquals(919,bits.setBit(663,8));
    }

    @Test
    void setBitTest2(){ // set bit number 15 in 36498 -> returns 52882
        assertEquals(52882,bits.setBit(36498,14));
    }

    @Test
    void clearBitTest1(){ // clear bit number 6 in 2374 -> returns 2310
        assertEquals(2310,bits.clearBit(2374,6));
    }

    @Test
    void clearBitTest2(){ // clear bit number 15 in 37710 -> returns 4942
        assertEquals(4942,bits.clearBit(37710,15));
    }

    @Test
    void updateBitTest1(){ // update bit number 5 in 846 -> returns 878
        assertEquals(878,bits.updateBit(846,5,true));
    }

    @Test
    void updateBitTest2(){ // update bit number 7 in 3566 -> returns 3438
        assertEquals(3438,bits.updateBit(3566,7,false));
    }

}