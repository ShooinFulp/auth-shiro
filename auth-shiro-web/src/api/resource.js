import request from "@/utils/request";

export function getList(data) {
  return request({
    url: "/resource/list",
    method: "post",
    data
  })
}

export function getResourceTree() {
  return request({
    url: "/resource/getResourceTree",
    method: "get",
  })
}
