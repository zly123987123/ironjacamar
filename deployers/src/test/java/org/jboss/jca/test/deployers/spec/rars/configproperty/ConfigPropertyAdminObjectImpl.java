/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.jca.test.deployers.spec.rars.configproperty;

import java.io.Serializable;

import javax.naming.NamingException;
import javax.naming.Reference;

import javax.resource.Referenceable;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;

import org.jboss.logging.Logger;

/**
 * ConfigPropertyAdminObjectImpl
 *
 * @version $Revision: $
 */
public class ConfigPropertyAdminObjectImpl implements ConfigPropertyAdminObjectInterface,
   ResourceAdapterAssociation, Referenceable, Serializable
{
   /** Serial version uid */
   private static final long serialVersionUID = 1L;

   private static Logger log = Logger.getLogger(ConfigPropertyAdminObjectImpl.class);

   /** The resource adapter */
   private ResourceAdapter ra;

   /** Reference */
   private Reference reference;

   /** default property */
   private String defaultProperty;

   /** property */
   private String property;

   /**
    * Default constructor
    */
   public ConfigPropertyAdminObjectImpl()
   {

   }

   /** 
    * Set default property
    * @param property The value
    */
   public void setDefaultProperty(String property)
   {
      log.info("DefaultProperty=" + property);
      this.defaultProperty = property;
   }

   /** 
    * Get default property
    * @return The value
    */
   public String getDefaultProperty()
   {
      return defaultProperty;
   }

   /** 
    * Set property
    * @param property The value
    */
   public void setProperty(String property)
   {
      log.info("Property=" + property);
      this.property = property;
   }

   /** 
    * Get property
    * @return The value
    */
   public String getProperty()
   {
      return property;
   }

   /**
    * Get the resource adapter
    *
    * @return The handle
    */
   public ResourceAdapter getResourceAdapter()
   {
      return ra;
   }

   /**
    * Set the resource adapter
    *
    * @param ra The handle
    */
   public void setResourceAdapter(ResourceAdapter ra)
   {
      this.ra = ra;
   }

   /**
    * Get the Reference instance.
    *
    * @return Reference instance
    * @exception NamingException Thrown if a reference can't be obtained
    */
   @Override
   public Reference getReference() throws NamingException
   {
      return reference;
   }

   /**
    * Set the Reference instance.
    *
    * @param reference A Reference instance
    */
   @Override
   public void setReference(Reference reference)
   {
      this.reference = reference;
   }

   /** 
    * Returns a hash code value for the object.
    * @return A hash code value for this object.
    */
   @Override
   public int hashCode()
   {
      int result = 17;
      if (defaultProperty != null)
         result += 31 * result + 7 * defaultProperty.hashCode();
      else
         result += 31 * result + 7;
      if (property != null)
         result += 31 * result + 7 * property.hashCode();
      else
         result += 31 * result + 7;
      return result;
   }

   /** 
    * Indicates whether some other object is equal to this one.
    * @param other The reference object with which to compare.
    * @return true if this object is the same as the obj argument, false otherwise.
    */
   @Override
   public boolean equals(Object other)
   {
      if (other == null)
         return false;
      if (other == this)
         return true;
      if (!(other instanceof ConfigPropertyAdminObjectImpl))
         return false;
      ConfigPropertyAdminObjectImpl obj = (ConfigPropertyAdminObjectImpl)other;
      boolean result = true; 
      if (result)
      {
         if (defaultProperty == null)
            result = obj.getDefaultProperty() == null;
         else
            result = defaultProperty.equals(obj.getDefaultProperty());
      }
      if (result)
      {
         if (property == null)
            result = obj.getProperty() == null;
         else
            result = property.equals(obj.getProperty());
      }
      return result;
   }


}
