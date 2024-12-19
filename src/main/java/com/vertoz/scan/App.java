package com.vertoz.scan;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.vertoz.controller.Controller;
import com.vertoz.model.Bid;
import com.vertoz.model.Creative;
import com.vertoz.model.SeatBid;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args ) throws UnsupportedEncodingException {
        System.out.println( "Hello World!" );
        

        Controller controller = new Controller();
        
        String json = "{\"id\":\"vza738c2a3-84bb-429d-8a10-b38af1cc6ced\",\"seatbid\":[{\"bid\":[{\"id\":\"c167d997-d661-46d8-a712-df765499a46b_1\",\"impid\":\"1\",\"price\":0.9,\"nurl\":\"http://beta-win.ingnsplx.com/win?i=c167d997-d661-46d8-a712-df765499a46b_1\\u0026c=3879\\u0026cr=3178\\u0026p=${AUCTION_PRICE}\\u0026e=1563\\u0026u=\\u0026cp=sigq6fJpZ7R-8kIk8i3Upg\\u0026r=90.0\\u0026s=728x90\\u0026h=textfeed.howgenric.com\\u0026m=8\\u0026ct=\\u0026cn=united+states\\u0026dt=desktop\\u0026si=19006\\u0026pi=32803\\u0026t=1728307291953\\u0026id=jCcx_iTK9Zw4veKcDNqlSw\\u0026aud=0\\u0026sp=0\\u0026stat=\\u0026pc=\\u0026o=linux\\u0026ov=\\u0026dm=\\u0026cat=IAB2%2CIAB1%2CIAB4%2CIAB3\\u0026ap=6\\u0026br=chrome\\u0026hr=13\\u0026sn=\\u0026dmf=\\u0026ssn=beta+banner\\u0026con=cable%2Fdsl\\u0026ti=IXI801555V16BBCD\\u0026isp=qualispace\\u0026pid=0\\u0026ev=1\\u0026rfl=2\\u0026sid=9\\u0026adp=0.1\",\"adm\":\"\\u003cscript src='https://beta-adm-js.ingnsplx.com/adm.js?' adm='https://beta-adm.ingnsplx.com/adm-generator?pu=https%3A%2F%2Ftextfeed.howgeneric.com%2Fbannerdisplay.html\\u0026d=textfeed.howgenric.com\\u0026pi=32803\\u0026pn=\\u0026ip=dSwZjINCR3Y-_tWoRj-1TQ\\u0026si=19006\\u0026ui=\\u0026ti=IXI801555V16BBCD\\u0026ua=Mozilla%2F5.0+%28X11%3B+Linux+x86_64%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Chrome%2F129.0.0.0+Safari%2F537.36\\u0026bi=\\u0026if=NA\\u0026an=\\u0026di=NA\\u0026asu=\\u0026ap=6\\u0026dnt=0\\u0026sui=\\u0026sclk=\\u0026p=${AUCTION_PRICE}\\u0026aid=${AUCTION_ID}\\u0026c=3879\\u0026cr=3178\\u0026bid=c167d997-d661-46d8-a712-df765499a46b_1\\u0026e=1563\\u0026cu=united+states\\u0026ci=\\u0026lt=37.7510\\u0026lg=-97.8220\\u0026i=jCcx_iTK9Zw4veKcDNqlSw\\u0026stat=\\u0026dt=desktop\\u0026pc=\\u0026o=linux\\u0026ov=\\u0026dm=\\u0026cat=IAB2%2CIAB1%2CIAB4%2CIAB3\\u0026ap=6\\u0026br=chrome\\u0026hr=13\\u0026sn=\\u0026dmf=\\u0026ssn=beta+banner\\u0026con=cable%2Fdsl\\u0026isp=qualispace\\u0026s=728x90\\u0026ciso=\\u0026sg=\\u0026pid=0\\u0026ev=1\\u0026sid=9\\u0026cif=0' id='vrtzscript' div-id='c167d997-d661-46d8-a712-df765499a46b_1'\\u003e\\u003c/script\\u003e\",\"adid\":\"3178\",\"adomain\":[\"vertoz.com\"],\"iurl\":\"https://beta-creative.ingnsplx.com/%2F2023-04-28%2010%3A52%3A14.821.jpg\",\"cid\":\"3879\",\"crid\":\"3178\",\"cat\":[\"\"],\"w\":728,\"h\":90}]}],\"cur\":\"USD\",\"ext\":{\"gdpr\":0,\"us_privacy\":\"\",\"coppa\":0}}";
        
        Creative creative = controller.ScnnerController(json);
        
        if (creative == null) {
            System.err.println("Failed to parse creative JSON.");
            return;
        }
        
        
        String imageUrl = null;
        if (creative.getSeatbid() != null && !creative.getSeatbid().isEmpty()) {
            SeatBid seatBid = creative.getSeatbid().get(0);
            if (seatBid.getBid() != null && !seatBid.getBid().isEmpty()) {
                Bid bid = seatBid.getBid().get(0);
                imageUrl = bid.getIurl();
            }
        }

        if (imageUrl == null) {
            System.err.println("No image URL found in creative.");
            return;
        }
        
        System.out.println("image url -->"+ imageUrl);
        
        Controller.RecognizationProcess(imageUrl);
       
         imageUrl = "https://www.shutterstock.com/shutterstock/photos/2023769807/display_1500/stock-vector-pivoting-as-strategy-change-and-redirection-for-growth-tiny-person-concept-new-plan-motion-with-2023769807.jpg";
        
        Controller.checkRedirect(imageUrl);
        
	}  
}
