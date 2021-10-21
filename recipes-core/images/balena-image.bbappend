#
# SolidRun SolidSense solidrun-n6g
#
IMAGE_FSTYPES_append_solidrun-n6g = " balenaos-img"
BALENA_IMAGE_BOOTLOADER_solidrun-n6g = "u-boot"
BALENA_BOOT_PARTITION_FILES_solidrun-n6g = " \
    zImage-initramfs-${MACHINE}.bin:/zImage \
    imx6dl-hummingboard2-emmc-som-v15.dtb:/imx6dl-hummingboard2-emmc-som-v15.dtb \
    imx6q-hummingboard2-emmc-som-v15.dtb:/imx6q-hummingboard2-emmc-som-v15.dtb \
    ${SPL_BINARY}:/${SPL_BINARY} \
    u-boot-${MACHINE}.${UBOOT_SUFFIX}:/u-boot-${MACHINE}.${UBOOT_SUFFIX} \
"
IMAGE_CMD_balenaos-img_append_solidrun-n6g () {
    # SolidRun SolidSense solidrun-n6g needs uboot written at a specific location along with SPL
    dd if=${DEPLOY_DIR_IMAGE}/${SPL_BINARY} of=${BALENA_RAW_IMG} conv=notrunc seek=1 bs=1K
    dd if=${DEPLOY_DIR_IMAGE}/u-boot-${MACHINE}.${UBOOT_SUFFIX} of=${BALENA_RAW_IMG} conv=notrunc seek=69 bs=1K
}
