#!/bin/bash

#
# Copyright (c) 2001-2016 Primeton Technologies, Ltd.
# All rights reserved.
#
# author: ZhongWen Li (mailto:lizw@primeton.com)
#

#
# modify mac address (docker run with '--privileged' argument)
# license file binds mac address 02:42:5e:87:9a:e2
#
ifconfig eth0 hw ether 02:42:5e:87:9a:e2

#
# if has others work to do, write to here
#

# TODO XXX