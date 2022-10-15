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

### Live Commands

> Live Commands allow you to execute user-defined actions. These commands have access to application runtime data and
> can be used to gather metrics, trigger alerts, or perform other actions.

#### [Add Breakpoint](./src/main/java/spp/demo/command/AddBreakpoint.java)

This demonstration shows how to add a "non-breaking breakpoint" to a running application. The **Add Breakpoint** command
is useful for debugging production applications without impacting the end user.

#### [Add Log](./src/main/java/spp/demo/command/AddLog.java)

This demonstration shows how to add a log statement to a running application. The **Add Log** command is useful for
increasing the verbosity of a running application with logs that output directly into the IDE.

#### [Tail Logs](./src/main/java/spp/demo/command/TailLogs.java)

This demonstration shows how to follow existing logs from a running application. The **Tail Logs** command works with
most logging frameworks, including Log4j, Logback, and SLF4J.

### Live Indicators

> Live Indicators allow you to automatically display user-defined metrics in the IDE. These metrics can be used to
> monitor the health of your application or provide insight into the current state of the application.

#### [Failing Endpoint](./src/main/java/spp/demo/indicator/FailingEndpoint.java)

This demonstration shows how failing endpoints can be detected and displayed in the IDE. The **Failing Endpoint**
indicator is useful for identifying endpoints that are actively failing and require attention.

## Bugs & Features

Bug reports and feature requests can be created [here](https://github.com/sourceplusplus/sourceplusplus/issues).
