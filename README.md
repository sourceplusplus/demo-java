# ![](https://github.com/sourceplusplus/sourceplusplus/blob/master/.github/media/sourcepp_logo.svg)

![GitHub](https://img.shields.io/github/license/sourceplusplus/protocol)
![GitHub release](https://img.shields.io/github/v/release/sourceplusplus/sourceplusplus?include_prereleases)
![Uptime](https://img.shields.io/endpoint?url=https%3A%2F%2Fraw.githubusercontent.com%2Fsourceplusplus%2Fstatus%2Fmaster%2Fapi%2Fsource-demos%2Fuptime.json)
![Uptime](https://img.shields.io/endpoint?url=https%3A%2F%2Fraw.githubusercontent.com%2Fsourceplusplus%2Fstatus%2Fmaster%2Fapi%2Fsource-demos%2Fresponse-time.json)

## What is this?

This project holds Java-based feature demonstrations for [Source++](https://github.com/sourceplusplus/sourceplusplus),
the open-source live coding platform. These demonstrations are meant to be used as a reference for how to use Source++
in your own projects.

## How to use?

Install the Source++ plugin via the JetBrains Marketplace by searching for: `Source++`.
Alternatively, you can download the Source++ plugin directly from [here](https://plugins.jetbrains.com/plugin/12033-source-).

Once the plugin is installed, check out the demos below. Each demo contains instructions explaining how to use it.

> Note: You do not need to run this code to play with the demos. This application is hosted on our publicly accessible servers.

## Demos

### [Add Breakpoint](./src/main/java/spp/demo/command/AddBreakpoint.java)

This demonstration shows how to add a "non-breaking breakpoint" to a running application. The **Add Breakpoint** command
is useful for debugging production applications without impacting the end user.

For more information, see the [AddBreakpoint](./src/main/java/spp/demo/command/AddBreakpoint.java) class.

### [Tail Logs](./src/main/java/spp/demo/command/TailLogs.java)

This demonstration shows how to tail logs from a running application. Logs can be filtered by individual statements,
methods, and classes. The **Tail Logs** command works for any application that uses a logging framework that is
supported by Source++.

For more information, see the [TailLogs](./src/main/java/spp/demo/command/TailLogs.java) class.

## Bugs & Features

Bug reports and feature requests can be created [here](https://github.com/sourceplusplus/sourceplusplus/issues).
