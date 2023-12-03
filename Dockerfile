FROM ghcr.io/graalvm/native-image-community:21 AS build
RUN microdnf install findutils
COPY . /build
WORKDIR /build
RUN chmod +x gradlew
RUN ./gradlew nativeCompile

FROM alpine:3.18
RUN apk add gcompat
WORKDIR /app
COPY --from=build /build/build/native/nativeCompile/weather-server /app/weather-server
ENTRYPOINT ["/app/weather-server"]