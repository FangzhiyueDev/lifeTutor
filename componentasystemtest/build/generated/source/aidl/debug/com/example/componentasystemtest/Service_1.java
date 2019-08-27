/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /media/fang/codeAndNote/developer/androidNew/androidProject/android/lifeTutor/componentasystemtest/src/main/aidl/com/example/componentasystemtest/Service_1.aidl
 */
package com.example.componentasystemtest;
// Declare any non-default types here with import statements

public interface Service_1 extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.componentasystemtest.Service_1
{
private static final java.lang.String DESCRIPTOR = "com.example.componentasystemtest.Service_1";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.componentasystemtest.Service_1 interface,
 * generating a proxy if needed.
 */
public static com.example.componentasystemtest.Service_1 asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.componentasystemtest.Service_1))) {
return ((com.example.componentasystemtest.Service_1)iin);
}
return new com.example.componentasystemtest.Service_1.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_getName:
{
data.enforceInterface(descriptor);
java.lang.String _result = this.getName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements com.example.componentasystemtest.Service_1
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String getName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public java.lang.String getName() throws android.os.RemoteException;
}
