/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.ftpserver.clienttests;

import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.impl.DefaultFtpServer;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.listener.nio.NioListener;

/**
*
* @author The Apache MINA Project (dev@mina.apache.org)
* @version $Rev$, $Date$
*
*/
public class ConnectPickPortTest extends ClientTestTemplate {

    @Override
    protected boolean isConnectClient() {
        return false;
    }

    @Override
    protected boolean isStartServer() {
        return false;
    }

    @Override
    protected FtpServerFactory createServer() throws Exception {
        FtpServerFactory server = super.createServer();
        
        ListenerFactory factory = new ListenerFactory();
        factory.setPort(0);
        
        server.addListener("default", factory.createListener());
        
        return server;
    }

    public void testPortWithZeroPort() throws Exception {
        assertEquals(0, ((NioListener) server.getServerContext().getListener(
                "default")).getPort());

        server.start();

        assertTrue(((NioListener) server.getServerContext().getListener(
                "default")).getPort() > 0);
    }
}