package org.github.valtoni.matrix.facilities;

import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.DecapsulateException;
import javax.crypto.KEM;
import javax.crypto.KEM.Encapsulator;
import javax.crypto.KEM.Encapsulated;
import javax.crypto.KEM.Decapsulator;
import javax.crypto.SecretKey;
import javax.crypto.spec.DHParameterSpec;


import java.security.Security;
import java.security.Provider;
import java.security.Provider.Service;
import java.util.Set;
import java.util.HashSet;

public class KemGeneration {

    public static final String ELLIPTIC_CURVE = "EC";
    public static final String SECP256R1 = "secp256r1";
    public static final String DIFFIE_HELLMAN = "DiffieHellman";
    public static final String KEMINSTANCE = "DHKEM";

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b: bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0'); // Adiciona zero à esquerda se necessário
            }
            hexString.append(hex);
        }
        return "0x" + hexString;
    }

    public static void listAvailableAlgs(String alg) {
        var algorithms = new HashSet<String>();
        for (Provider provider: Security.getProviders()) {
            for (Service service : provider.getServices()) {
                if (service.getType().equals(alg)) {
                    algorithms.add(service.getAlgorithm());
                }
            }
        }
        System.out.format("Available %s algorithms:\n", alg);
        for (String algorithm : algorithms) {
            System.out.println(algorithm);
        }
    }

    public static void listKEMAlgorithms() {
        listAvailableAlgs("KEM");
    }

    public static void listKeyPairGeneratorAlgorithms() {
        listAvailableAlgs("KeyPairGenerator");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, DecapsulateException, InvalidParameterSpecException, InvalidAlgorithmParameterException {
        // Print Available KEM Algorithms
        listKEMAlgorithms();
        // Print Available KeyPairGenerator Algorithms
        listKeyPairGeneratorAlgorithms();
        // Generate key pais (public/private) using Elliptic Curve
        // EC is a nice choice for limited devices. A key with 256 bits in EC is equivalent to 3072 bits in Diffie-Hellman.
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(ELLIPTIC_CURVE);
        ECGenParameterSpec ecSpec = new ECGenParameterSpec(SECP256R1);
        kpg.initialize(ecSpec);
        KeyPair keyPair = kpg.generateKeyPair();
        // Initialize KEM using DHKEM algorithm
        KEM kem = KEM.getInstance(KEMINSTANCE);
        // Create sender encapsulator
        Encapsulator sender = kem.newEncapsulator(keyPair.getPublic());
        // Here we encapsulate the secret key
        Encapsulated encapsulated = sender.encapsulate();
        // Get encapsulated key in bytes
        byte[] encapsulatedKey = encapsulated.encapsulation();
        // Decapsulate key in receiver side
        Decapsulator receiver = kem.newDecapsulator(keyPair.getPrivate());
        SecretKey decapsulatedKey = receiver.decapsulate(encapsulatedKey);
        // Verify visually if the keys are equals
        System.out.println("Encapsulated...: " + bytesToHex(encapsulated.key().getEncoded()));
        System.out.println("Decapsulated...: " + bytesToHex(decapsulatedKey.getEncoded()));
    }

}
