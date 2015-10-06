package hansteen.core

import groovy.json.JsonBuilder
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo

class TradeController {

    /**
     * Accepts incoming chat messages sent by browsers and routes them
     * to the 'chat' topic that all browser clients are subscribed to.
    **/
    @MessageMapping("/trade/buy")
    @SendTo("/topic/trade")
    protected def buy(user, tradeInfo) {
        /**
         * Use the awesome Groovy JsonBuilder to convert a dynamically-defined
         * data structure to JSON.
        **/
        def builder = new JsonBuilder()
        builder {
            message(chatMsg)
            timestamp(new Date())
        }
        builder.toString()
    }
}
