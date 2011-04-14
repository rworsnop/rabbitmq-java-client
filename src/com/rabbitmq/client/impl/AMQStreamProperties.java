//  The contents of this file are subject to the Mozilla Public License
//  Version 1.1 (the "License"); you may not use this file except in
//  compliance with the License. You may obtain a copy of the License
//  at http://www.mozilla.org/MPL/
//
//  Software distributed under the License is distributed on an "AS IS"
//  basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
//  the License for the specific language governing rights and
//  limitations under the License.
//
//  The Original Code is RabbitMQ.
//
//  The Initial Developer of the Original Code is VMware, Inc.
//  Copyright (c) 2007-2011 VMware, Inc.  All rights reserved.
//

package com.rabbitmq.client.impl;

import java.util.Date;
import java.util.Map;
import java.util.Hashtable;

import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.StreamProperties;

public abstract class AMQStreamProperties
        extends AMQContentHeader implements StreamProperties {
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        AMQStreamProperties spClone = (AMQStreamProperties) super.clone();
        
        Map<String, Object> thisHeaders = getHeaders();
        if (thisHeaders != null) {
            Map<String, Object> headers = new Hashtable<String, Object>();
            headers.putAll(thisHeaders);
            spClone.setHeaders(headers);
        }
        
        Date thisTimestamp = getTimestamp();
        if (thisTimestamp != null) {
            spClone.setTimestamp((Date) thisTimestamp.clone());
        }
        
        return spClone;
    }
}