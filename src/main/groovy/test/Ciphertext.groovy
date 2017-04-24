package test

/**
 * Created by user on 4/23/2017.
 */
class Ciphertext {
    private String uuid
    private String key
    private String encData
    private Crypto crypto

    public Ciphertext() {
    }

    public Ciphertext(String uuid, String data) {
        this.uuid = uuid
        this.crypto = new Crypto()

        this.key = crypto.getKey()

        this.encData = Base64.getEncoder().
                encodeToString(crypto.encrypt(data.getBytes()))
    }

    Plaintext viewEncrypter() {
        crypto = new Crypto(key)

        byte[] decData = Base64.getDecoder().
                decode(encData.getBytes())
        String data = new String(crypto.decrypt(decData))
        return new Plaintext(uuid, data)
    }

    String getUuid() {
        return uuid
    }

    void setUuid(String uuid) {
        this.uuid = uuid
    }

    String getKey() {
        return key
    }

    void setKey(String key) {
        this.key = key
    }

    String getEncData() {
        return encData
    }

    void setEncData(String encData) {
        this.encData = encData
    }
}
