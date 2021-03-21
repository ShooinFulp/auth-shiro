import request from '@/utils/request'

export function getList(data) {
  return request({
    url: '/user/list',
    method: 'post',
    data
  })
}
export function createUser(user){
  return request({
    url:"/user/add",
    method:'post',
    data:user
  })
}

export function updateUser(user){
  return request({
    url:"/user/update",
    method:'post',
    data:user
  })
}

export function removeUser(userIds){
  return request({
    url:"/user/remove",
    method:'post',
    data:userIds
  })
}

export function allocRole(data) {
  return request({
    url: '/user/allocRole',
    method: 'post',
    data
  })
}
