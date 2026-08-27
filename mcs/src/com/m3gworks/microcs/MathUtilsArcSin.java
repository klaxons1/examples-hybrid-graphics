package com.m3gworks.microcs;

/**
 * Math utilities for J2ME applications
 * Contains optimized implementations of math functions
 */
public final class MathUtilsArcSin {

    // Polynomial approximation coefficients for arcsin
    private static final double ASIN_APPROX_COEF_A = 1.5707288D;
    private static final double ASIN_APPROX_COEF_B = -0.212114D;
    private static final double ASIN_APPROX_COEF_C = 0.074261D;
    private static final double ASIN_APPROX_COEF_D = -0.0187293D;
    private static final double PI = 3.141592653589793D; // Math.PI not available in some J2ME profiles

    /**
     * Calculates arcsine using polynomial approximation
     * Optimized for J2ME environment where Math.asin may not be available
     *
     * @param value input value in range [-1.0, 1.0]
     * @return arcsine value in radians in range [0, PI]
     */
    public static double asin(double value) {
        // Clamp value to valid range [-1.0, 1.0]
        if (value > 1.0D) {
            value = 1.0D;
        } else if (value < -1.0D) {
            value = -1.0D;
        }

        double absValue = Math.abs(value);

        // Calculate polynomial: a + b*x + c*x^2 + d*x^3
        double x2 = absValue * absValue;    // x^2
        double x3 = x2 * absValue;          // x^3
        double polynomial = ASIN_APPROX_COEF_A +
                ASIN_APPROX_COEF_B * absValue +
                ASIN_APPROX_COEF_C * x2 +
                ASIN_APPROX_COEF_D * x3;

        // Main approximation formula: sqrt(1 - |x|) * polynomial
        double result = Math.sqrt(1.0D - absValue) * polynomial;

        // Adjust result for negative inputs using identity: asin(-x) = PI - asin(x)
        if (value < 0.0D) {
            result = PI - result;
        }

        return result;
    }
}