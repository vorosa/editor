#!/bin/bash
echo "Generating code for all modeled projects."
trap 'echo "=== error executing command $BASH_COMMAND ==="; exit 1' ERR

WORKSPACE=<path to workspace>
./BridgePoint_CLI.sh Build $WORKSPACE -project a
./BridgePoint_CLI.sh Build $WORKSPACE -project b
./BridgePoint_CLI.sh Build $WORKSPACE -project c
./BridgePoint_CLI.sh Build $WORKSPACE -project d
./BridgePoint_CLI.sh Build $WORKSPACE -project e
./BridgePoint_CLI.sh Build $WORKSPACE -project f
./BridgePoint_CLI.sh Build $WORKSPACE -project g
./BridgePoint_CLI.sh Build $WORKSPACE -project h
./BridgePoint_CLI.sh Build $WORKSPACE -project i
echo 'generated all models for deployment'

pushd deployment/src
./build_copy.sh
popd
echo '=== copied all sources to deployment'

./BridgePoint_CLI.sh Build $WORKSPACE -project a_test
./BridgePoint_CLI.sh Build $WORKSPACE -project b_test
./BridgePoint_CLI.sh Build $WORKSPACE -project c_test
./BridgePoint_CLI.sh Build $WORKSPACE -project d_testbench
./BridgePoint_CLI.sh Build $WORKSPACE -project e_testbench
./BridgePoint_CLI.sh Build $WORKSPACE -project f_testbench

