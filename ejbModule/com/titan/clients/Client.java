package com.titan.clients;

import java.util.Properties;
import java.util.concurrent.CompletionException;

import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

import org.apache.taglibs.standard.lang.jstl.ComplexValue;
import org.jboss.security.plugins.audit.JBossAuditContext;

import com.titan.domain.Cabin;
import com.titan.travelagent.TravelAgentRemote;

public class Client {
	public static void main(String[] args)
    {
        try
        {
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("TitanCruises/TravelAgentBean!com.titan.travelagent.TravelAgentRemote");
            
            //Object ref = jndiContext.lookup("java:module/TravelAgentBean");
            TravelAgentRemote dao = (TravelAgentRemote)
                PortableRemoteObject.narrow(ref,TravelAgentRemote.class);
            

            Cabin cabin_1 = new Cabin();
            cabin_1.setId(1);
            cabin_1.setName("Kajuta luksusowa");
            cabin_1.setDeckLevel(1);
            cabin_1.setShipId(1);
            cabin_1.setBedCount(3);

            dao.createCabin(cabin_1);

            Cabin cabin_2 = dao.findCabin(1);
            System.out.println(cabin_2.getName());
            System.out.println(cabin_2.getDeckLevel());
            System.out.println(cabin_2.getShipId());
            System.out.println(cabin_2.getBedCount());

        }
        catch (javax.naming.NamingException ne)
        {
            ne.printStackTrace();
        }
    }
	
	
    public static Context getInitialContext() throws javax.naming.NamingException
    {
    	Properties p = new Properties();
    	p.put(Context.INITIAL_CONTEXT_FACTORY, 	org.jboss.naming.remote.client.InitialContextFactory.class.getName());
    	p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
    	p.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
    	p.put("jboss.naming.client.ejb.context",true);
        return new javax.naming.InitialContext(p); 
    }
}
