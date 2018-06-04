// EventBusService.aidl
package com.dongnao.eventbus;

// Declare any non-default types here with import statements
import com.dongnao.eventbus.Request;
import com.dongnao.eventbus.Responce;
interface EventBusService {
    Responce send(in Request request);

}
