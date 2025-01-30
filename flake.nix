{
  description = "React + Spring boot flake";

  inputs.nixpkgs.url = "github:nixos/nixpkgs/nixos-24.11";
  inputs.flake-utils.url = "github:numtide/flake-utils";

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let pkgs = nixpkgs.legacyPackages.${system};
      in {
        devShell = with pkgs; mkShell
          {
            nativeBuildInputs = [
              bun
              vite
              jdk # jdk 21
              (pkgs.writeShellScriptBin "init" ''
                #!/usr/bin/env bash
                cd frontendexample
                bun install
                cd ../springdemo 
                ./gradlew build
              '')
            ];

            buildInputs = [
              /* zstd
              alsa-lib
              libxkbcommon
              udev
              vulkan-loader
              wayland
              xorg.libX11
              xorg.libXcursor
              xorg.libXi
              xorg.libXrandr */
            ];

          };
      });
}

