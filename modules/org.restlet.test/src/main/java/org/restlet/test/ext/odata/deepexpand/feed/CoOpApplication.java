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

package org.restlet.test.ext.odata.deepexpand.feed;

import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.CharacterSet;
import org.restlet.data.Form;
import org.restlet.data.LocalReference;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.routing.Router;

public class CoOpApplication extends Application {
    private class MyClapRestlet extends Restlet {
        String file;

        boolean updatable;

        public MyClapRestlet(Context context, String file, boolean updatable) {
            super(context);
            this.file = file;
            this.updatable = updatable;
        }

        @Override
        public void handle(Request request, Response response) {
            if (Method.GET.equals(request.getMethod())) {
                Form form = request.getResourceRef().getQueryAsForm();
                String uri = "/"
                        + this.getClass().getPackage().getName()
                                .replace(".", "/") + "/" + file;
                if (form.getFirstValue("$expand") != null) {
                    uri += " expand "
                            + form.getFirstValue("$expand").replace(",", ", ")
                                    .replace('/', '-');
                }
                if (form.getFirstValue("$skiptoken") != null) {
                    uri += form.getFirstValue("$skiptoken");
                }

                Response r = getContext().getClientDispatcher().handle(
                        new Request(Method.GET, LocalReference
                                .createClapReference(LocalReference.CLAP_CLASS,
                                        uri + ".xml")));

                r.getEntity().setCharacterSet(
                        getMetadataService().getDefaultCharacterSet());

                response.setEntity(r.getEntity());
                response.setStatus(r.getStatus());
            } else if (!updatable) {
                response.setStatus(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);
            }
        }
    }

    @Override
    public Restlet createInboundRoot() {

        getMetadataService().setDefaultCharacterSet(CharacterSet.UTF_8);
        getConnectorService().getClientProtocols().add(Protocol.CLAP);
        Router router = new Router(getContext());

        router.attach("/$metadata", new MyClapRestlet(getContext(), "metadata",
                false));

        router.attach("/JobPosting", new MyClapRestlet(getContext(),
                "JobPosting", false));

        router.attach("/Job", new MyClapRestlet(getContext(), "Job", false));

        router.attach("/Language", new MyClapRestlet(getContext(), "Language",
                false));

        router.attach("/University", new MyClapRestlet(getContext(),
                "University", false));

        return router;
    }

}
