package cn.tuling.nettyadv.kryocodec;

import cn.tuling.nettyadv.vo.EncryptUtils;
import cn.tuling.nettyadv.vo.MakeMsgID;
import cn.tuling.nettyadv.vo.MsgHeader;
import cn.tuling.nettyadv.vo.MyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark老师
 * 类说明：序列化器的测试类
 */
public class TestKryoCodeC {

    public MyMessage getMessage(int j) {
		String content = "abcdefg--------AAAAAA:" + j;
		MyMessage myMessage = new MyMessage();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setMsgID(MakeMsgID.getID());
		msgHeader.setType((byte) 1);
		msgHeader.setPriority((byte) 7);
		msgHeader.setMd5(EncryptUtils.encryptObj(content));
		Map<String, Object> attachment = new HashMap<String, Object>();
		for (int i = 0; i < 10; i++) {
			attachment.put("city --> " + i, "mark " + i);
		}
		msgHeader.setAttachment(attachment);
		myMessage.setMyHeader(msgHeader);
		myMessage.setBody(content);
		return myMessage;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
		TestKryoCodeC testC = new TestKryoCodeC();

		for (int i = 0; i < 5; i++) {
			ByteBuf sendBuf = Unpooled.buffer();
            MyMessage message = testC.getMessage(i);
            System.out.println("Encode:"+message);
            KryoSerializer.serialize(message, sendBuf);
			MyMessage decodeMsg = (MyMessage) KryoSerializer.deserialize(sendBuf);
			System.out.println("Decode:"+decodeMsg);
			System.out
				.println("-------------------------------------------------");
		}

    }

}
