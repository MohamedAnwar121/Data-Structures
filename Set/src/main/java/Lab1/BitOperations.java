package Lab1;

public class BitOperations implements IBitsOperations {

    @Override
    public int getBit(int number, int position) {
        return (number & (1 << position)) >> position;
    }

    @Override
    public int setBit(int number, int position) {
        return (number | (1 << position));
    }

    @Override
    public int clearBit(int number, int position) {
        number = number & ~(1 << position);
        return number;
    }

    @Override
    public int updateBit(int number, int position, boolean value) {
        if (value) number = number | (1 << position);
        else number = number & ~(1 << position);
        return number;
    }
}
