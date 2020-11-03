package utils;

import static core.DriverFactory.getDriver;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utilitarios {

	public static void fullPageScreenshot(String path, String nome) {

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(getDriver());
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(path + "_" + nome + ".png"));

		} catch (Exception e) {
			System.out.println("erro ao tentar Tirar e Armazenar o Printscreen");
		}
	}

	public static DateTimeFormatter formatter() {
		return DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
	}

	public static String caminhoScreenshot() {
		return "src" + File.separator + "test" + File.separator + "resources" + File.separator + "evidencias"
				+ File.separator + "screenshots" + File.separator;
	}

	public static void deletandoScreenshotsFile() {

		File fileSucesso = new File(caminhoScreenshot() + "sucesso");
		File fileErro = new File(caminhoScreenshot() + "erro");

		if (fileSucesso.listFiles().length > 0) {
			Arrays.stream(fileSucesso.listFiles()).forEach(File::delete);
		}
		if (fileErro.listFiles().length > 0) {
			Arrays.stream(fileErro.listFiles()).forEach(File::delete);
		}

	}

	public static void screenshotsCriarFiles() {

		File fileScreenshot = new File(caminhoScreenshot());
		File fileErro = new File(caminhoScreenshot() + "erro");
		File fileSucesso = new File(caminhoScreenshot() + "sucesso");

		fileScreenshot.mkdir();
		fileSucesso.mkdir();
		fileErro.mkdir();

	}

}
