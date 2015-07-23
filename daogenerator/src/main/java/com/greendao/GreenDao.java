package com.greendao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDao {

    private static final String GENERATED_SRC_DIR = "./app/gen-src";

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, GreenDao.class.getPackage().getName());
        Entity entity = schema.addEntity("Memo");
        entity.addStringProperty("Data").notNull();
        entity.addStringProperty("DueDate").notNull();
        // need to create the folder by ourself, or the generateAll() method will cause I/O error
        createDirs(Paths.get(GENERATED_SRC_DIR));
        new DaoGenerator().generateAll(schema, GENERATED_SRC_DIR);
    }

    private static void createDirs(Path path) throws IOException {
        if (Files.notExists(path, LinkOption.NOFOLLOW_LINKS)) {
            Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
            FileAttribute<Set<PosixFilePermission>> attrs = PosixFilePermissions.asFileAttribute(perms);
            Files.createDirectories(path, attrs);
        }
    }
}