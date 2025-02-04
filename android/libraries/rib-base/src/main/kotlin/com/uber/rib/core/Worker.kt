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

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Interface used when creating a manager or helper class that should be bound to an interactor's
 * lifecycle using a binder like [WorkerBinder]. The worker event is decoupled from the
 * interactor's actual lifecycle so that we're not stuck moving these classes around if there are
 * other lifecycles we're interested in.
 */
public interface Worker {

  /**
   * Specifies in which [CoroutineDispatcher] WorkerBind.bind will be operating on
   *
   * NOTE: Default implementation will be using RibDispatchers.Unconfined to keep "caller" backward compatibility on existing usages
   */
  @JvmDefault
  public val coroutineDispatcher: CoroutineDispatcher
    get() = RibDispatchers.Unconfined

  /**
   * Called when worker is started.
   *
   * @param lifecycle The lifecycle of the worker to use for subscriptions.
   */
  @JvmDefault
  public fun onStart(lifecycle: WorkerScopeProvider) {}

  /** Called when the worker is stopped.  */
  @JvmDefault
  public fun onStop() {}
}
