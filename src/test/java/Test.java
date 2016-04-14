import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {

	public static void main(String[] args) {

		try {

			String boundary = "Boundary-b1ed-4060-99b9-fca7ff59c113";

			String Enter = "\r\n";

			File file = new File("D:\\1.jpg");
			FileInputStream inputStream = new FileInputStream(file);

			URL url = new URL(
					"http://localhost:8081/yuegou/v1/guideApp/product/upload");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);

			conn.connect();

			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

			String part1 = "--" + boundary + Enter
					+ "Content-Type: application/octet-stream" + Enter
					+ "Content-Disposition: form-data; filename=\""
					+ file.getName() + "\"; name=\"file\"" + Enter + Enter;

			String part2 = Enter + "--" + boundary + Enter
					+ "Content-Type: text/plain" + Enter
					+ "Content-Disposition: form-data; name=\"parameter\""
					+ Enter + Enter + "hifreud" + Enter + "--" + boundary
					+ "--";

			byte[] fileBytes = new byte[inputStream.available()];
			inputStream.read(fileBytes);

			dos.writeBytes(part1);
			dos.write(fileBytes);
			dos.writeBytes(part2);

			dos.flush();
			dos.close();
			inputStream.close();

			System.out.println("status code: " + conn.getResponseCode());

			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void upload(byte[] data, String fileName, String address)
			throws IOException {

		DataOutputStream outputStream = null;
		HttpURLConnection conn = null;
		try {

			String boundary = String.format("Boundary-%s",
					System.currentTimeMillis());

			String Enter = "\r\n";

			URL url = new URL(address);

			conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);

			conn.connect();

			outputStream = new DataOutputStream(conn.getOutputStream());

			String part1 = "--" + boundary + Enter
					+ "Content-Type: application/octet-stream" + Enter
					+ "Content-Disposition: form-data; filename=\"" + fileName
					+ "\"; name=\"file\"" + Enter + Enter;

			String part2 = Enter + "--" + boundary + Enter
					+ "Content-Type: text/plain" + Enter
					+ "Content-Disposition: form-data; name=\"parameter\""
					+ Enter + Enter + "hifreud" + Enter + "--" + boundary
					+ "--";

			outputStream.writeBytes(part1);
			outputStream.write(data);
			outputStream.writeBytes(part2);

			outputStream.flush();
			
			System.out.println("status code: " + conn.getResponseCode());
			
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}

	}
}