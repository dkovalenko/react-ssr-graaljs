# react-ssr-graaljs

React server-side rendering example using express, esbuild, node, graaljs

GraalVM is an alternative JVM and JDK distribution from Oracle which supports running Java with support for JavaScript, Ruby and Python. GraalVM’s polyglot capabilities make it possible to mix multiple programming languages in a single application.

To run Javascript you have several options:
1. Use drop-in replacement for “node” binary. All should work, hopefully. But test everything twice 🤞
2. Use the GraalJS engine as a library on stock JDK. 
3. Use GraalJS bundled with the runtime of the GraalVM.

More on this in my blog:
