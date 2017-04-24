package enc

import org.junit.Test


/**
 * Created by user on 4/23/2017.
 */
class CryptoTest {
    @Test
    void encrypt() throws Exception {
        String str = "hello world"
        Crypto crypto = new Crypto()
        byte[] enc = crypto.encrypt(str.getBytes())
        byte[] dec = crypto.decrypt(enc)
        String decStr = new String(dec)
        assert(str.equals(decStr))
    }

    @Test
    void convert() throws Exception {
        Crypto orig = new Crypto()
        String key = orig.getKey()
        println(key)
        Crypto copy = new Crypto(key)
        assert (copy.getKey().equals(orig.getKey()))
    }

}