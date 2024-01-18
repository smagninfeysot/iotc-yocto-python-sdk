docker:
	docker build -t yocto-builder . && \
	docker run --rm -it \
	--security-opt seccomp=unconfined \
	-v  $${PWD}:$${PWD}:Z \
	-v ~/.gitconfig:/etc/gitconfig:Z \
	yocto-builder \
	--workdir=$${PWD}


build:
	docker run --rm -it \
	--security-opt seccomp=unconfined \
	-v  $${PWD}:$${PWD}:Z \
	-v ~/.gitconfig:/etc/gitconfig:Z \
	yocto-builder \
	--workdir=$${PWD} \
	/bin/bash -c 'source ./sources/poky/oe-init-build-env ./maaxboard/build/ && bitbake core-image-base && exit'

env:
	docker run --rm -it \
	--security-opt seccomp=unconfined \
	-v  $${PWD}:$${PWD}:Z \
	-v ~/.gitconfig:/etc/gitconfig:Z \
	yocto-builder \
	--workdir=$${PWD} \
	/bin/bash -c 'source ./sources/poky/oe-init-build-env ./maaxboard/build/ && bash'