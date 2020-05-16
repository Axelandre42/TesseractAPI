package tesseract.graph;

import tesseract.api.IConnectable;
import tesseract.util.Dir;

import javax.annotation.ParametersAreNonnullByDefault;


/**
 * A class that acts as a controller for a connectivity of the connectables.
 */
@ParametersAreNonnullByDefault
public class Connectivity {

    /**
     * Initialize connectivity for a given instance.
     *
     * @param connectable The given instance.
     * @return Gets the connectivity for instance.
     */
    public static byte of(IConnectable connectable) {
        byte connectivity = 0;

        for (Dir direction : Dir.VALUES) {
            if (connectable.connects(direction)) {
                connectivity = Connectivity.set(connectivity, direction.getIndex());
            }
        }

        return connectivity;
    }

    /**
     * Bitwise set operation.
     *
     * @param connectivity The provided state.
     * @param side The direction index.
     * @return Connectivity state for a connection.
     */
    public static byte set(byte connectivity, int side) {
        return (byte) (connectivity | (1 << side));
    }

    /**
     * Bitwise clear operation.
     *
     * @param connectivity The provided state.
     * @param side The direction index.
     * @return Connectivity state for a connection.
     */
    public static byte clear(byte connectivity, int side) {
        return (byte) (connectivity & ~(1 << side));
    }

    /**
     * Bitwise toggle operation.
     *
     * @param connectivity The provided state.
     * @param side The direction index.
     * @return Connectivity state for a connection.
     */
    public static byte toggle(byte connectivity, int side) {
        return (byte) (connectivity ^ (1 << side));
    }

    /**
     * Bitwise check operation.
     *
     * @param connectivity The provided state.
     * @param side The direction index.
     * @return True if a connection is exist, false otherwise.
     */
    public static boolean has(byte connectivity, int side) {
        return (connectivity & (1 << side)) > 0;
    }
}
