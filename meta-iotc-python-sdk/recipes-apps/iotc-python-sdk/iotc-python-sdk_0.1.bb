# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://git@github.com/avnet-iotconnect/iotc-python-sdk.git;protocol=ssh;branch=master-std-21"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "dc94de8c037384eae355259926f3edbf6e9b83a3"

S = "${WORKDIR}/git/iotconnect-sdk-1.0"

# NOTE: no Makefile found, unable to determine what needs to be done
inherit setuptools3

#PYPI_PACKAGE = "iotconnect-sdk"

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	:
}

distutils_do_install () {
	# Specify install commands here
	:
}

