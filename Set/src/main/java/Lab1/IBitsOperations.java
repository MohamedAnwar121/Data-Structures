package Lab1;

public interface IBitsOperations {

    int getBit(int number, int position);

    int setBit(int number, int position);

    int clearBit(int number, int position);

    int updateBit(int number, int position, boolean value);
}
