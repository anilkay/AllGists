class AESExample {
public static void AESencryptDecrypt(String plaintext) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            var key = keyGenerator.generateKey();
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] decryp = cipher.doFinal(plaintext.getBytes());
            String encryptedText=new String(Base64.getEncoder().encode(decryp));
            System.out.println("Cipher Text: "+encryptedText);
            //Encryption is ended.
            //Decryption is started
            Cipher decipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            decipher.init(Cipher.DECRYPT_MODE, key, cipher.getParameters());
            byte[] decrypt = decipher.doFinal(decryp);
            String plain = new String(decrypt);
            //Decryption is ended.
            System.out.println("Decrypted: " + plain);
            //İT's work fine.
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }


}