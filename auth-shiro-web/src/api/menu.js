import request from "@/utils/request";

export function getList(data) {
  return request({
    url: '/menu/list',
    method: 'post',
    data
  })
}

export function createMenu(data) {
  return request({
    url: '/menu/add',
    method: 'post',
    data
  })
}

export function updateMenu(data) {
  return request({
    url: '/menu/update',
    method: 'post',
    data
  })
}

export function removeMenu(data) {
  return request({
    url: '/menu/delete',
    method: 'post',
    data
  })
}

export function getMenu(id) {
  return request({
    url: '/menu/get/' + id,
    method: 'get'
  })
}

export function getMenuByParentId(parentId) {
  return request({
    url: '/menu/getMenuByParentId',
    method: 'get',
    params: {parentId}
  })
}
