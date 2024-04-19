package com.example.demo.Config;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtConstant {
public static String JWT_HEADER= "Authorization";
private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

// Define the size of the secure key in bytes
private static final int KEY_SIZE_BYTES = 32; // 256 bits

// Initialize the secret key for JWT signing and verification
private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SIGNATURE_ALGORITHM);

// Provide methods to access the secret key
public static SecretKey getSecretKey() {
    return SECRET_KEY;
}
}
