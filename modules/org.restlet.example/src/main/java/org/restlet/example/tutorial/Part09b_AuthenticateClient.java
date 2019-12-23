/**
 * Copyright 2005-2019 Talend
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * https://restlet.talend.com/
 * 
 * Restlet is a registered trademark of Talend S.A.
 */

package org.restlet.example.tutorial;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Status;
import org.restlet.resource.ClientResource;

/**
 * Authenticating to an HTTP server.
 * 
 * @author Jerome Louvel
 */
public class Part09b_AuthenticateClient {
    public static void main(String[] args) throws Exception {
        // Prepare the request
        ClientResource resource = new ClientResource("http://localhost:8111/");

        // Add the client authentication to the call
        ChallengeScheme scheme = ChallengeScheme.HTTP_BASIC;
        ChallengeResponse authentication = new ChallengeResponse(scheme,
                "scott", "tiger");
        resource.setChallengeResponse(authentication);

        // Send the HTTP GET request
        resource.get();

        if (resource.getStatus().isSuccess()) {
            // Output the response entity on the JVM console
            resource.getResponseEntity().write(System.out);
        } else if (resource.getStatus()
                .equals(Status.CLIENT_ERROR_UNAUTHORIZED)) {
            // Unauthorized access
            System.out
                    .println("Access authorized by the server, check your credentials");
        } else {
            // Unexpected status
            System.out.println("An unexpected status was returned: "
                    + resource.getStatus());
        }
    }

}
