package com.fx.software.spritesplit.utili;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 项目名称: SpriteSplit.
 * 创建时间: 2016/8/18.
 * 创 建 人: Var_雨中行.
 * 类 描 述: .
 */
public class LoaderFile {

    private BufferedImage image;

    public BufferedImage load(String path) {
        if (!path.equals("")) {
            try {
                image = ImageIO.read(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return image;
    }
}
