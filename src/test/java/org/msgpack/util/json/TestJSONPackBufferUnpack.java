package org.msgpack.util.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.TestSet;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;
import org.msgpack.util.json.JSON;


public class TestJSONPackBufferUnpack extends TestSet {

    @Test @Override
    public void testBoolean() throws Exception {
	super.testBoolean();
    }

    @Override
    public void testBoolean(boolean v) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	packer.writeBoolean(v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	boolean ret = unpacker.readBoolean();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testByte() throws Exception {
	super.testByte();
    }

    @Override
    public void testByte(byte v) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	packer.writeByte(v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	byte ret = unpacker.readByte();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testShort() throws Exception {
	super.testShort();
    }

    @Override
    public void testShort(short v) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	packer.writeShort(v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	short ret = unpacker.readShort();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testInteger() throws Exception {
	super.testInteger();
    }

    @Override
    public void testInteger(int v) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	packer.writeInt(v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	int ret = unpacker.readInt();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testLong() throws Exception {
	super.testLong();
    }

    @Override
    public void testLong(long v) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	packer.writeLong(v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	long ret = unpacker.readLong();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testFloat() throws Exception {
	super.testFloat();
    }

    @Override
    public void testFloat(float v) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
        if(((Float)v).isInfinite() || ((Float)v).isNaN()) {
            try {
                packer.writeFloat(v);
                fail("JSONPacker should reject infinite and NaN value");
            } catch (IOException ex) {
                assertTrue(ex instanceof IOException);
            }
            return;
        }
	packer.writeFloat(v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	float ret = unpacker.readFloat();
	assertEquals(v, ret, 10e-10);
    }

    @Test @Override
    public void testDouble() throws Exception {
	super.testDouble();
    }

    @Override
    public void testDouble(double v) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
        if(((Double)v).isInfinite() || ((Double)v).isNaN()) {
            try {
                packer.writeDouble(v);
                fail("JSONPacker should reject infinite and NaN value");
            } catch (IOException ex) {
                assertTrue(ex instanceof IOException);
            }
            return;
        }
	packer.writeDouble(v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	double ret = unpacker.readDouble();
	assertEquals(v, ret, 10e-10);
    }

    @Test @Override
    public void testNil() throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	packer.writeNil();
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	unpacker.readNil();
    }

    //@Test @Override  // FIXME JSON Unpacker doesn't support BigInteger
	ByteArrayOutputStream out = new ByteArrayOutputStream();
    public void testBigInteger() throws Exception {
	super.testBigInteger();
    }

    @Override
    public void testBigInteger(BigInteger v) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	packer.writeBigInteger(v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	BigInteger ret = unpacker.readBigInteger();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testString() throws Exception {
	super.testString();
    }

    @Override
    public void testString(String v) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	packer.writeString(v);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	String ret = unpacker.readString();
	assertEquals(v, ret);
    }

    @Test @Override
    public void testByteArray() throws Exception {
	super.testByteArray();
    }

    @Override
    public void testByteArray(byte[] v) throws Exception {
        // FIXME JSONPacker doesn't support bytes
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	//packer.writeByteArray(v);
        String str = new String(v);
	packer.writeString(str);
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	//byte[] ret = unpacker.readByteArray();
	String ret = unpacker.readString();
	assertEquals(str, ret);
    }

    @Test @Override
    public void testList() throws Exception {
	super.testList();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public <E> void testList(List<E> v, Class<E> elementClass) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	if (v == null) {
	    packer.writeNil();
	} else {
	    packer.writeArrayBegin(v.size());
	    for (Object o : v) {
		packer.write(o);
	    }
	    packer.writeArrayEnd();
	}
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
        if (unpacker.trySkipNil()) {
            assertEquals(null, v);
            return;
        }
	int size = unpacker.readArrayBegin();
	List ret = new ArrayList(size);
	for (int i = 0; i < size; ++i) {
	    ret.add(unpacker.read(elementClass));
	}
	unpacker.readArrayEnd();
	assertEquals(v.size(), ret.size());
	Iterator v_iter = v.iterator();
	Iterator ret_iter = ret.iterator();
	while (v_iter.hasNext()) {
	    assertEquals(v_iter.next(), ret_iter.next());
	}
    }

    @Test @Override
    public void testMap() throws Exception {
	super.testMap();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public <K, V> void testMap(Map<K, V> v, Class<K> keyElementClass, Class<V> valueElementClass) throws Exception {
	MessagePack msgpack = new JSON();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	Packer packer = msgpack.createPacker(out);
	if (v == null) {
	    packer.writeNil();
	} else {
	    packer.writeMapBegin(v.size());
	    for (Map.Entry<Object, Object> e : ((Map<Object, Object>) v).entrySet()) {
		if (!(e.getKey() instanceof String)) {
		    try {
			packer.write(e.getKey());
			fail("JSONPacker should reject non-String value for the map key");
		    } catch (IOException ex) {
			assertTrue(ex instanceof IOException);
		    }
		    return;
		}
		packer.write(e.getKey());
		packer.write(e.getValue());
	    }
	    packer.writeMapEnd();
	}
	byte[] bytes = out.toByteArray();
	Unpacker unpacker = msgpack.createBufferUnpacker(bytes);
	if (unpacker.trySkipNil()) {
	    assertEquals(null, v);
	    return;
	}
	int size = unpacker.readMapBegin();
	Map ret = new HashMap(size);
	for (int i = 0; i < size; ++i) {
	    Object key = unpacker.read(keyElementClass);
	    Object value = unpacker.read(valueElementClass);
	    ret.put(key, value);
	}
	unpacker.readMapEnd();
	assertEquals(v.size(), ret.size());
	for (Map.Entry<Object, Object> e : ((Map<Object, Object>) v).entrySet()) {
	    Object value = ret.get(e.getKey());
	    assertEquals(e.getValue(), value);
	}
    }
}
