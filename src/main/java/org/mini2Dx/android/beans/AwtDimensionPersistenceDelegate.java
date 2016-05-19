/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.mini2Dx.android.beans;

import java.awt.Dimension;

import org.apache.harmony.beans.BeansUtils;
import org.mini2Dx.android.beans.DefaultPersistenceDelegate;
import org.mini2Dx.android.beans.Encoder;
import org.mini2Dx.android.beans.Expression;

class AwtDimensionPersistenceDelegate extends DefaultPersistenceDelegate {
    @Override
    protected Expression instantiate(Object oldInstance, Encoder enc) {
        Dimension dimension = (Dimension) oldInstance;
        return new Expression(dimension, dimension.getClass(), BeansUtils.NEW,
                new Object[] { dimension.width, dimension.height });
    }
}