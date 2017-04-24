package test
/**
 * Created by user on 4/23/2017.
 *
 * This objects holds the data as plaintext and is
 * used for the input of the '/encrypt' path
 */
class Plaintext {

    private String uuid
    private String data

    Plaintext() {
    }

    Plaintext(String uuid, String data) {
        this.uuid = uuid
        this.data = data
    }

    Ciphertext viewDecrypter() {
        return new Ciphertext(uuid, data)
    }

    @Override String toString() {
        Byte[] decArray = Base64.getDecoder().decode(data.getBytes())
        String dec = new String(decArray)
        return new String("user " + uuid + " send data: " + data +
                " dec: " + dec)
    }

    String getId() {
        return uuid
    }

    String getData() {
        return data
    }
    void setUuid(String uuid) {
        this.uuid = uuid
    }

    void setData(String newData) {
        this.data = newData
    }


}
