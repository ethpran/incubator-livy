/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.livy.server.recovery

import scala.reflect.ClassTag

import org.apache.livy.LivyConf

/**
 * This is a blackhole implementation of StateStore.
 * Livy will use this when session recovery is disabled.
 */
class BlackholeStateStore(livyConf: LivyConf) extends StateStore(livyConf) {
  def set(key: String, value: Object): Unit = {}

  def get[T: ClassTag](key: String): Option[T] = None

  def getChildren(key: String): Seq[String] = List.empty[String]

  def remove(key: String): Unit = {}
}
