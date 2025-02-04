/*
 * Copyright (C) 2017. Uber Technologies
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.uber.rib.core

import com.uber.rib.core.lifecycle.WorkerEvent
import io.reactivex.Observable

/** Helper to unit test [Worker] instances.  */
public object WorkerHelper {
  /**
   * Creates a [WorkerScopeProvider] that can be driven by a test observable.
   *
   * @param lifecycle to wrap.
   * @return a [WorkerScopeProvider].
   */
  @JvmStatic
  public fun createScopeProvider(lifecycle: Observable<WorkerEvent>): WorkerScopeProvider {
    return WorkerScopeProvider(lifecycle)
  }
}
