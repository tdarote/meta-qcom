inherit cmake qprebuilt pkgconfig

SUMMARY = "QCOM Smart codec video control logic"
DESCRIPTION = "QCOM library for smart video codec control logic."

LICENSE = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

# Dependencies.
DEPENDS += "qcom-fastcv-binaries"
DEPENDS += "glib-2.0"

FILESPATH =+ "${WORKSPACE}:"

SRC_URI = "file://vendor/qcom/proprietary/iot-core-algs/qti-video-ctrl/"
S = "${UNPACKDIR}/vendor/qcom/proprietary/iot-core-algs/qti-video-ctrl"

EXTRA_OECMAKE += "-DSYSROOT_INCDIR=${STAGING_INCDIR}"
EXTRA_OECMAKE += "-DSYSROOT_LIBDIR=${STAGING_LIBDIR}"
EXTRA_OECMAKE += "-DKERNEL_BUILDDIR=${STAGING_KERNEL_BUILDDIR}"
EXTRA_OECMAKE += "-DIOT_CORE_ALGS_INSTALL_INCDIR=${includedir}/iot-core-algs"
EXTRA_OECMAKE += "-DIOT_CORE_ALGS_INSTALL_BINDIR=${bindir}"
EXTRA_OECMAKE += "-DIOT_CORE_ALGS_INSTALL_LIBDIR=${libdir}"

INSANE_SKIP:${PN} = "dev-so"
FILES:${PN} += "${bindir}"
FILES:${PN} += "${libdir}"
FILES:${PN} += "${libdir}/pkgconfig"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
