package enc

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import java.util.concurrent.atomic.AtomicLong

import org.springframework.web.bind.annotation.RestController

/**
 * Created by user on 4/23/2017.
 */



@RestController
class Controller {
    private static final String template = "Hello, %s!"
    private final AtomicLong counter = new AtomicLong()

    @RequestMapping(value = "/encrypt", method = RequestMethod.POST)
    Ciphertext encrypt(@RequestBody  Plaintext enc) {
        return enc.viewDecrypter()
    }

    @RequestMapping(value = "/decrypt", method = RequestMethod.POST)
    Plaintext decrypt(@RequestBody Ciphertext dec) {
        return dec.viewEncrypter()
    }
}
