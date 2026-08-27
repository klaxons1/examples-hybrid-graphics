package com.m3gworks.microcs;

/**
 * Highly optimized 3D math utilities for J2ME
 * Minimal method calls - inlined operations for maximum performance
 */
public final class MathUtils {

    /**
     * Dot product - single optimized method that handles everything
     * No unnecessary method calls - everything inlined
     */
    public static float dotProduct(float[] vec1, float[] vec2) {
        if (vec1.length != vec2.length) {
            throw new ArithmeticException();
        }

        float result = 0.0f;

        // Direct computation - no method calls
        for(int i = 0; i < vec1.length; ++i) {
            result += vec1[i] * vec2[i];
        }

        return result;
    }

    /**
     * Cross product for 3D vectors - completely self-contained
     */
    public static float[] crossProduct(float[] vec1, float[] vec2) {
        if (vec1.length == 3 && vec2.length == 3) {
            return new float[] {
                    vec1[1] * vec2[2] - vec1[2] * vec2[1],
                    vec1[2] * vec2[0] - vec1[0] * vec2[2],
                    vec1[0] * vec2[1] - vec1[1] * vec2[0]
            };
        } else {
            throw new ArithmeticException();
        }
    }

    /**
     * Vector length with integrated square root
     */
    public static float vectorLength(float[] vec) {
        float sum = 0.0f;

        // Everything in one loop - no external calls
        for(int i = 0; i < vec.length; ++i) {
            sum += vec[i] * vec[i];
        }

        return (float)Math.sqrt(sum);
    }

    /**
     * Normalize vector - complete operation in one method
     */
    public static float[] normalizeVector(float[] vec) {
        // Calculate length directly (no method call)
        float lengthSq = 0.0f;
        for(int i = 0; i < vec.length; ++i) {
            lengthSq += vec[i] * vec[i];
        }
        float length = (float)Math.sqrt(lengthSq);

        // Normalize in the same method
        float[] result = new float[vec.length];
        for(int i = 0; i < result.length; ++i) {
            result[i] = vec[i] / length;
        }

        return result;
    }

    /**
     * Vector projection - complete computation in one method
     * No calls to dotProduct or vectorLength
     */
    public static float[] vectorProjection(float[] vec, float[] ontoVec) {
        // Calculate dot product directly
        float dot = 0.0f;
        for(int i = 0; i < vec.length; ++i) {
            dot += vec[i] * ontoVec[i];
        }

        // Calculate ontoVec length squared directly
        float ontoLengthSq = 0.0f;
        for(int i = 0; i < ontoVec.length; ++i) {
            ontoLengthSq += ontoVec[i] * ontoVec[i];
        }

        float scale = dot / ontoLengthSq;
        float[] result = new float[vec.length];

        for(int i = 0; i < result.length; ++i) {
            result[i] = ontoVec[i] * scale;
        }

        return result;
    }

    /**
     * Vector rejection - everything inlined, no temporary arrays
     */
    public static float[] vectorRejection(float[] vec, float[] ontoVec) {
        // Combined dot product calculation
        float dotVA = 0.0f, dotAA = 0.0f;
        for(int i = 0; i < vec.length; ++i) {
            dotVA += vec[i] * ontoVec[i];
            dotAA += ontoVec[i] * ontoVec[i];
        }

        float scale = dotVA / dotAA;
        float[] result = new float[vec.length];

        for(int i = 0; i < result.length; ++i) {
            result[i] = vec[i] - ontoVec[i] * scale;
        }

        return result;
    }

    /**
     * Add two vectors - simple and fast
     */
    public static float[] addVectors(float[] vec1, float[] vec2) {
        float[] result = new float[vec1.length];
        for(int i = 0; i < vec1.length; ++i) {
            result[i] = vec1[i] + vec2[i];
        }
        return result;
    }
}