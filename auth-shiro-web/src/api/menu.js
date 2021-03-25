import request from "@/utils/request";

export function getList(data) {
  return request({
    url: '/menu/list',
    method: 'post',
    data
  })
}
