package euler;

import java.math.BigInteger;

public class Problem_097 {

    static String last10digits() {
        BigInteger nonMersennePrime = BigInteger.valueOf(28433);
        BigInteger pow = BigInteger.valueOf(2).pow(7830457);
        nonMersennePrime = nonMersennePrime.multiply(pow).add(BigInteger.ONE);
        return nonMersennePrime.toString().substring(nonMersennePrime.toString().length()-10);
    }
}
